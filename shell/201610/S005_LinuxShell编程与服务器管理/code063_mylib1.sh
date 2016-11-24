#!/bin/bash

_getip(){
    local temp r ip
    [ -z "$1" ] && return
    FUNREPLY=()
    temp=$(ifconfig $1 | grep "inet addr")
    r=${temp/inet addr:/}
    ip=${r/ Bcast*/}
    FUNREPLY=($ip)
}
