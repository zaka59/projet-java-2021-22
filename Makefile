###################################################
#                    VARIABLES                    #
###################################################

EXEC_TEST=java -jar test4poo.jar
CLASSES_DIR=cd classes
SRC_DIR=cd src
TESTS_DIR=cd tests
REMOVE=rm -rf
JC_TEST= javac -classpath test4poo.jar
JAR= jar cvfm
ALL_TESTS= tests/athleticCompetition/*.java \
		   tests/athleticCompetition/competition/*.java \
		   tests/athleticCompetition/competition/selection/*.java \
		   tests/athleticCompetition/event/*.java \
		   tests/athleticCompetition/event/listener/*.java \
		   tests/athleticCompetition/match/*.java

JUNIT_JAR=jar/junit.jar

###################################################

all: cls tests doc jar

###################################################
#             COMPILATION DES CLASSES             #
###################################################

cls: 
	@echo "compiling classes..."
	@$(SRC_DIR) && javac athleticCompetition/*.java \
	   				     athleticCompetition/competition/*.java \
	   				     athleticCompetition/competition/selection/*.java \
	   				     athleticCompetition/match/*.java \
	   				     athleticCompetition/event/*.java \
	   				     athleticCompetition/event/listener/*.java \
	   				     athleticCompetition/exception/*.java \
	   				     athleticCompetition/util/*.java \
	   				     athleticCompetition/main/*.java \
						 -d ../classes 

###################################################



###################################################
#                     EXECUTION                   # 
###################################################

LeagueMain: cls
	@$(CLASSES_DIR) && java athleticCompetition.main.LeagueMain

TournamentMain: cls
	@$(CLASSES_DIR) && java athleticCompetition.main.TournamentMain

ChampionsLeague: cls
	@$(CLASSES_DIR) && java athleticCompetition.main.ChampionsLeague

MasterMain: cls
	@$(CLASSES_DIR) && java athleticCompetition.main.MasterMain

ChampionsLeagueRigged: cls
	@$(CLASSES_DIR) && java athleticCompetition.main.ChampionsLeagueRigged "FC Barcelone"

###################################################



###################################################
#             COMPILATION DES TESTS               #
###################################################

tests: cls
	@echo "compiling tests..."
	@javac -d classes -cp classes:$(JUNIT_JAR) $(ALL_TESTS)

###################################################


###################################################
#               EXECUTION DES TESTS               #
###################################################

run_tests: tests
	@java -jar $(JUNIT_JAR) --class-path classes --scan-class-path
	

###################################################	



###################################################
#                  DOCUMENTATION                  #
###################################################
	
doc:
	@echo "generating doc..."
	@$(SRC_DIR) && javadoc -quiet athleticCompetition/*.java \
	   				     athleticCompetition/competition/*.java \
	   				     athleticCompetition/competition/selection/*.java \
	   				     athleticCompetition/match/*.java \
	   				     athleticCompetition/event/*.java \
	   				     athleticCompetition/event/listener/*.java \
	   				     athleticCompetition/exception/*.java \
						 -d ../docs/doc 


# UNAME_S := $(shell uname -s)
# open_doc:
#     ifeq ($(UNAME_S),Linux)
#         @xdg-open docs/doc/index.html
#     endif
#     ifeq ($(UNAME_S),Darwin)
#         @open docs/doc/index.html
#     endif
#     ifeq ($(OS),Windows_NT)
#         @docs/doc/index.html
#     endif

###################################################


###################################################
#                CREATION DES JAR                 #
###################################################


jar:
	@echo "creating .jar files..."
	@make League.jar
	@make Tournament.jar
	@make Master.jar
	@make ChampionsLeague.jar
	
League.jar:
	@$(CLASSES_DIR) && jar cvfm ../jar/$@ ../docs/manifest/manifest-League athleticCompetition > /dev/null

Tournament.jar: 
	@$(CLASSES_DIR) && jar cvfm ../jar/$@ ../docs/manifest/manifest-Tournament athleticCompetition > /dev/null

Master.jar: 
	@$(CLASSES_DIR) && jar cvfm ../jar/$@ ../docs/manifest/manifest-Master athleticCompetition > /dev/null

ChampionsLeague.jar: 
	@$(CLASSES_DIR) && jar cvfm ../jar/$@ ../docs/manifest/manifest-ChampionsLeague athleticCompetition > /dev/null

###################################################



###################################################
#                     AUTRES                      #
###################################################

all: cls tests


clean:
	@echo "cleaning..."
	@rm -rf classes/*
	@rm -rf docs/doc/*

.PHONY:	doc clean tests all run_tests LeagueMain TournamentMain MasterMain ChampionsLeague ChampionsLeagueRigged jar

###################################################



#AUTHORS : Zakaria El Khayari et Yoni Gaudiere
