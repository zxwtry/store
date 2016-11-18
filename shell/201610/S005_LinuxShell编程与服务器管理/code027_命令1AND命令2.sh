#!/bin/bash
a=20
if grep -q "rm" fn.sh && [ $a -lt 100 ]; then
    echo "OK"
else
    echo "Not OK"
fi
