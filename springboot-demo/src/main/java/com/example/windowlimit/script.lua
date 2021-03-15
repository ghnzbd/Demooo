
--根据score删除数据
redis.call("zremrangebyscore",KEYS[1],ARGV[1],ARGV[2])

--获取个数
local zSetLen = redis.call("zcard", KEYS[1])

if tonumber(zSetLen) > tonumber(ARGV[3]) then
    return tonumber(0)
end
--zadd添加数据
local res = redis.call("zadd",KEYS[1], ARGV[4], ARGV[5])
return tonumber(res)


