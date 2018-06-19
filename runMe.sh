### Projet Hearsthstone


# compilation du modele

javac -cp bin:lib/* -d bin src/hearthstone/*/*.java


# compilation de la classe principale

javac -cp bin:lib/* -d bin src/hearthstone/Hearthstone.java



# compilation des cas de tests junit

javac -cp bin:lib/* -d bin tests/*.java


echo -e "Running tests :\n\n"
# execution des cas de tests

java -cp bin:lib/* TestRunner


echo -e "Running Hearthstone :\n\n"
# execution de la classe principale

java -cp bin:lib/* hearthstone.Hearthstone