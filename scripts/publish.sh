#!/bin/bash
host=`hostname`
user=`whoami`
dir=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

if [ "$user" != "alcortes" -a "$host" != "bat" ] ; then
    echo "This script only works for alcortes@bat" >/dev/stderr;
    exit 1;
fi

mount | grep -q 'alcortes@violin.it.uc3m.es:/users/prof/alcortes/lib/www on /home/alcortes/mnt/www'
if [ "$?" != "0" ] ; then
    mount-www
    mount | grep -q 'alcortes@violin.it.uc3m.es:/users/prof/alcortes/lib/www on /home/alcortes/mnt/www'
    if [ "$?" != "0" ] ; then
        echo "Cannot mount alcortes web page" >/dev/stderr;
        exit 1;
    fi
fi

cp -r $dir/../out/pub/* ~/mnt/www/asig/1415/ps-ging/
