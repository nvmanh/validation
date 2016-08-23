#!/bin/bash
# Script make by HaiPQ@Framgia
ABSPATH=$(cd "$(dirname "$0")"; pwd)
cd $ABSPATH
echo 'CheckStyle updating....';
wget https://raw.githubusercontent.com/KaKaVip/framgia-android-ci/master/config/checkstyle/google_checks.xml -O checkstyle/google_checks.xml
wget https://raw.githubusercontent.com/KaKaVip/framgia-android-ci/master/config/checkstyle/suppressions.xml -O checkstyle/suppressions.xml
echo 'CheckStyle done';
echo 'Lint updating....';
wget https://raw.githubusercontent.com/KaKaVip/framgia-android-ci/master/config/lint/lint.xml -O lint/lint.xml
echo 'Lint done';
