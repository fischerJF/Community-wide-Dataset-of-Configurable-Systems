#!/bin/bash

# List file deleted from gitHub. In this case, all my files are under vendor dir
git log --diff-filter=D --summary | grep delete   | egrep vendor > deletedFiles.txt
 
#prepare a script to check out the deleted files [which I am interested]
for file in $(cat deletedFiles.txt)\
do \
     echo git checkout $(git rev-list -n 1 HEAD -- "$file")^ -- "$file"; done | egrep vendor > getBackFiles.sh \
done
 
# change file permission so that I can run
chmod 755 getBackFiles.sh
 
# run the script created
./getBackFiles.sh