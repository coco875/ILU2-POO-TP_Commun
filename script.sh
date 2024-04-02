#!/bin/bash
for file in ./src/*/*.java; do
    echo "Converting $file to UTF-8"
    vim -c "set encoding=utf8" -c "set fileencoding=utf8" -c "wq" "$file"
done
