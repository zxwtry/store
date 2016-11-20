#!/bin/bash
read yname
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
