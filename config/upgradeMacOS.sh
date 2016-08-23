#!/bin/bash
# Script make by HaiPQ@Framgia
ABSPATH=$(cd "$(dirname "$0")"; pwd)
cd $ABSPATH
echo 'CheckStyle updating....';
curl https://raw.githubusercontent.com/KaKaVip/framgia-android-ci/master/config/checkstyle/google_checks.xml -o checkstyle/google_checks.xml
curl https://raw.githubusercontent.com/KaKaVip/framgia-android-ci/master/config/checkstyle/suppressions.xml -o checkstyle/suppressions.xml
echo 'CheckStyle done';
echo 'Lint updating....';
curl https://raw.githubusercontent.com/KaKaVip/framgia-android-ci/master/config/lint/lint.xml -o lint/lint.xml
echo 'Lint done';
