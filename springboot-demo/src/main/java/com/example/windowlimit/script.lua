
--根据score删除数据
redis.call("zremrangebyscore",KEYS[1],ARGV[1],ARGV[2])

--获取个数
local zSetLen = redis.call("zcard", KEYS[1])
if zSetLen > ARGV[3] then
    return 0
end
--zadd添加数据
local res = redis.call("zadd", ARGV[4], ARGV[5])
if res==1 then
    return 1
else
    return 0
end
