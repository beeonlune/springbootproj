#!/bin/bash
#enter input encoding here
FROM_ENCODING="us-ascii"
#output encoding(UTF-8)
TO_ENCODING="UTF-8"
#convert
CONVERT=" iconv  -f   $FROM_ENCODING  -t   $TO_ENCODING"
for file in *.css; do
        $CONVERT   "$file"   -o  "${file%.css}.utf8.converted"
done
exit 0

