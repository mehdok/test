#include <stdio.h>
#include <string>
class StringCoding
{
private:
// The key to use in encrypting the string
std::string sKey;
public:
// The constructor, uses a preset key
StringCoding( void )
{
sKey = "ATest";
}
// Main constructor, allows the user to specify a key
StringCoding( const char *strKey )
{
if ( strKey )
sKey = strKey;
else
sKey = "ATest";
}
// Copy constructor
StringCoding( const StringCoding& aCopy )
{
sKey = aCopy.sKey;
}
public:
// Methods
std::string Encode( const char *strIn );
std::string Decode( const char *strIn );
private:
std::string Xor( const char *strIn );
};
std::string StringCoding::Xor( const char *strIn )
{
std::string sOut = "";
int nIndex = 0;
for ( int i=0; i<(int)strlen(strIn); ++i )
{
char c = (strIn[i] ^ sKey[nIndex]);
sOut += c;
nIndex ++;
if ( nIndex == sKey.length() )
nIndex = 0;
}
return sOut;
}
// For XOR encoding, the encode and decode methods are the same.
std::string StringCoding::Encode( const char *strIn )
{
return Xor( strIn );
}
std::string StringCoding::Decode( const char *strIn )
{
return Xor( strIn );
}
int main(int argc, char **argv)
{
if ( argc < 2 )
{
printf("Usage: ch1_1 inputstring1 [inputstring2...]\n");
exit(1);
}
StringCoding key("XXX");
for ( int i=1; i<argc; ++i )
{
std::string sEncode = key.Encode( argv[i] );
printf("Input String : [%s]\n", argv[i] );
printf("Encoded String: [%s]\n", sEncode.c_str() );
std::string sDecode = key.Decode( sEncode.c_str() );
printf("Decoded String: [%s]\n", sDecode.c_str() );
}
printf("%d strings encoded\n", argc-1);
return 0;
}
