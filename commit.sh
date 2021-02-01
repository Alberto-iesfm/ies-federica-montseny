#! /bin/bash

MESSAGE=$1

git add -u
git add -A *

git commit -m "$MESSAGE"

git push

