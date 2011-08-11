all:
	javac MamaMia.java
clean:
	rm *.class
zip:
	zip MamaMia.zip -xi *.java
tar:
	tar -czvf MamaMia.tar.gz *.java
test:
		time -p ./tester.sh "java MamaMia 1 2 2 3 10 20"
		time -p ./tester.sh "java MamaMia 3 2 2 3 4 5" 
		time -p ./tester.sh "java MamaMia 5 3 2 3 2 3"

Bigtest:	
		time -p ./tester.sh "java MamaMia 2 42 42 1764 72364 74087"
		time -p ./tester.sh "java MamaMia 2 4 1 3 9000 9500"

