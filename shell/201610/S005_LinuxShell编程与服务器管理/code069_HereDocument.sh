#!/bin/bash

exec 6<<EOF
line1
line2
line3
EOF

while read <&6
do
    echo $REPLY
done
