 #!/bin/bash

echo "Cleaning up"
rm -rf out
mkdir out

echo "Generating Java sources from wsdl files"
for F in wsdl/*.wsdl ; do java -cp lib/*: org.apache.axis.wsdl.WSDL2Java $F; done
mv com out/

echo "Compiling"
javac -d out -cp :lib/* ./out/com/zeus/soap/zxtm/*/*.java

echo "Creating Jar"
cd out && jar cf Stingray-API.jar com/zeus