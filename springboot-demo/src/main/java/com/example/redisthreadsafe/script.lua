--根据key判断是否存在
local key = redis.call("EXISTS", KEYS[1])
--存在key
if tonumber(key) == 1 then
    --获取key的值
    local number = redis.call("GET", KEYS[1])
    --key的值小于阈值
    if tonumber(number) < tonumber(ARGV[1]) then
        redis.call("incrby", KEYS[1], ARGV[2])
        return 1
    else
        return 0
    end

else
    --不存在
    redis.call("SET", KEYS[1], ARGV[2])
    return 1
end