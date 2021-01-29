#! /bin/bash

MESSAGE=$1

git add -u *
git commit -m "$MESSAGE"
git push

