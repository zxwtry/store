#!/bin/bash

if ! grep -q "rm" ~/temp/test.sh; then
    echo "not found"
else
    echo "find rm command."
fi
