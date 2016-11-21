#!/bin/bash
read yname
shopt -s nocasematch
case $yname in
    AAAA | BBBB | CCCC)
        echo "long time no see."
        ;;
    D*)
        echo "nice to meet u."
        ;;
    *)
        echo "hello."
        ;;
esac
