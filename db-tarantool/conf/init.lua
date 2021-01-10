#!/usr/bin/env tarantool

local function init()
    box.schema.space.create('user_space', { if_not_exists = true })
    box.space.user_space:create_index('primary', { type = "TREE", unique = true, parts = { 1, 'unsigned' }, if_not_exists = true })
    box.space.user_space:create_index('login_idx', { type = 'HASH', unique = true, parts = { 2, 'string' }, if_not_exists = true })
    box.space.user_space:create_index('first_name_idx', { type = 'TREE', unique = false, parts = { 3, 'string' }, if_not_exists = true })
    box.space.user_space:create_index('last_name_idx', { type = 'TREE', unique = false, parts = { 4, 'string' }, if_not_exists = true })

    box.space.users:insert({1, "admin1", "123", "aaa", "bbb"})
    box.space.users:insert({2, "admin1", "123", "aaa", "bba"})
    box.space.users:insert({3, "admin1", "123", "aaa", "bbc"})
    box.space.users:insert({4, "admin1", "123", "aaa", "bbd"})
    box.space.users:insert({5, "admin1", "123", "aaa", "bdd"})
    box.space.users:insert({6, "admin1", "123", "aaa", "ddd"})
    box.space.users:insert({7, "admin1", "123", "aaa", "eee"})
    box.space.users:insert({8, "admin1", "123", "aaa", "aba"})
    box.space.users:insert({9, "admin1", "123", "aaa", "aaa"})
    box.space.users:insert({10, "admin1", "123", "aaa", "aab"})
    box.space.users:insert({11, "admin1", "123", "baa", "bbb"})
    box.space.users:insert({12, "admin1", "123", "baaaa", "bba"})
    box.space.users:insert({13, "admin1", "123", "baa", "bbc"})
    box.space.users:insert({14, "admin1", "123", "baa", "bbd"})
    box.space.users:insert({15, "admin1", "123", "bbb", "bdd"})
    box.space.users:insert({16, "admin1", "123", "bbb", "ddd"})
    box.space.users:insert({17, "admin1", "123", "abb", "eee"})
    box.space.users:insert({18, "admin1", "123", "bbb", "aba"})
    box.space.users:insert({19, "admin1", "123", "bbb", "aaa"})
    box.space.users:insert({20, "admin1", "123", "bbb", "aab"})
end

function search_by_first_name(prefix)
    local result = {}
    for _, tuple in box.space.user_space.index.first_name_idx:pairs({ prefix }, { iterator = 'GE' }) do
        if string.startswith(tuple[3], prefix, 1, -1) then
            table.insert(result, tuple)
        end
    end
    return result
end


box.cfg
    {
        pid_file='/var/run/tarantool/tarantool.pid',
        wal_dir='/var/lib/tarantool',
        listen=3301,
        vinyl_dir='/var/lib/tarantool',
        memtx_dir='/var/lib/tarantool',
        background = false,
        log_level = 5
    }

box.once('init', init)