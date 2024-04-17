#!/usr/bin/bash

set -eu

echo "----------------------------------------" > timestamp.txt
ls -la >> timestamp.txt
date +%F-%H%M%S >> timestamp.txt
echo "========================================" >> timestamp.txt
cat timestamp.txt