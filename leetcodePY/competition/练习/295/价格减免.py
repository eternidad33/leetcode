import re


def discountPrices(sentence: str, discount: int) -> str:
    d = (100 - discount) / 100
    return ' '.join(
        map(lambda w: re.sub(r'^\$(\d+(\.\d+)?)$', lambda matched: '$' + "{:.2f}".format(float(matched.group(1)) * d),
                             w), sentence.split(' ')))


s = discountPrices("there are $1 $2 and 5$ candies in the shop", 50)
print(s)
a = "ka3caz4837h6ada4 r1 $602 "
b = 9
s = discountPrices(a, b)
print(s)
a = "$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999"
b = 0
s = discountPrices(a, b)
print(s)
# $2$3 $10.00 $100.00 $1.00 200 $33.00 33$ $$ $99.00 $99999 $9999999999.00
# $2$3 $10.00 $100.00 $1.00 200 $33.00 33$ $$ $99.00 $99999.00 $9999999999.00
