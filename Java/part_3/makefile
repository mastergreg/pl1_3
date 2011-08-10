all:
	javac MamaMia.java
zip:
	zip MamaMia.zip -xi *.java
tar:
	tar -czvf MamaMia.tar.gz *.java
test:
		time -p java MamaMia 1 2 2 3 10 20
		time -p java MamaMia 3 2 2 3 4 5
		time -p java MamaMia 5 3 2 3 2 3

Bigtest:	
		time -p java MamaMia 2 42 42 1764 72364 74087
		time -p java MamaMia 2 4 1 3 9000 9500

