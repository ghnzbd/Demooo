--根据score删除数据
redis.call("zremrangebyscore",KEYS[1],ARGV[1],ARGV[2])

--获取个数
local zSetLen = redis.call("zcard", KEYS[1])



if tonumber(zSetLen) > tonumber(ARGV[4]) then
    return 0
end
--zadd添加数据
local res = redis.call("zadd",KEYS[1], ARGV[5], ARGV[6])
redis.call("expire",KEYS[1],ARGV[3])
return res


