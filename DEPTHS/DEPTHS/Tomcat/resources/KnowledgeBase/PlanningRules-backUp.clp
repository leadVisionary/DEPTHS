
;;-----KNOWLEDGE BASE  ---RULES FOR CREATING INSTRUCTIONAL PLAN----;; 

(clear)

(watch rules)

;;----- CONCEPT TEMPLATE----;; 
(deftemplate concepts
(slot ID)
(multislot prerequisite)
(slot ordinalNumber)
(slot minKnowledgeLevel ))

;;----- TEMPLATE THAT KEEPS LIST OF ALREADY LEARNED CONCEPTS----;;
(deftemplate passed_concepts
(multislot ID ( type INTEGER )))

;;----- STUDENT TEMPLATE ---KEEPS DATA ABOUT CURRENT STUDENT KNOWLEDGE LEVEL----;;
(deftemplate student
(slot ID ( type INTEGER )  )
(slot knowledgeLevel ( type INTEGER )))

;;----- CHECK CONCEPT RULE --- CHECK IF THE CONCEPT COULD BE INSERT IN INSTRUCTIONAL PLAN----;;
(defrule check_concept
 ?fact5 <- ( concepts (ID ?cID) (prerequisite $?pre)(minKnowledgeLevel ?mKnLev)(ordinalNumber ?oN))
?fact6 <- ( student (knowledgeLevel ?sKnLev))
?fact7 <-  ( passed_concepts  (ID $?pcID))
(test (and  (< ?mKnLev ?sKnLev) (subsetp $?pre $?pcID)))
=>
;;----- dodati poziv Java funkcije koja ce ubaciti dati koncept u instrukcioni plan----;;
(printout t "pravilo xyz aktivirano " ?cID crlf )

)



;;----- ADDING NEW CONCEPT TEMPLATE --- ADDS NEW CONCEPT TO THE PASSED CONCEPT LIST----;;
(defrule adding_passed_concept
 
?r1 <- (passed_concepts  (ID $?fID ))
?r2 <- (add-passed-concept ?xID)
=>
(retract ?r2)
(modify ?r1 (ID (insert$ $?fID (+ (length$ $?fID) 1) ?xID ))
)
(printout t "modifikacija - - - " $?fID "  - - - prosiren za---" ?xID  crlf))

(reset)
(run)