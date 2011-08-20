;;-----KNOWLEDGE BASE  ---RULES FOR CREATING INSTRUCTIONAL PLAN----;;

(clear)

(watch rules)
(watch facts)

;;----------------------------------------------------------------;;
;;--- PART CONCERNING CONCEPT PLANNING ---;;
;;----------------------------------------------------------------;;

;;----- CONCEPT TEMPLATE----;;
(deftemplate concepts
(slot ID )
(multislot prerequisite)
(slot ordinalNumber (type INTEGER))
(slot minKnowledgeLevel (type INTEGER)))

;;----- TEMPLATE THAT KEEPS LIST OF ALREADY LEARNED CONCEPTS----;;
(deftemplate passed_concepts
(slot ID  ))

;;-----TEMPLATE THAT KEEPS LIST OF CONCEPTS THAT ARE ADDED TO CONCEPT PLAN
(deftemplate concepts_added_in_plan
(slot ID )
)

;;----- STUDENT TEMPLATE ---KEEPS DATA ABOUT CURRENT STUDENT KNOWLEDGE LEVEL----;;
(deftemplate student
(slot ID ( type INTEGER ))
(slot knowledgeLevel ( type INTEGER )))

;;----- CHECK CONCEPT RULE --- CHECK IF THE CONCEPT COULD BE INSERT IN INSTRUCTIONAL PLAN----;;
(defrule check_concept
?fact1 <- ( concepts (ID ?cID) (prerequisite $?first ?one $?rest) (minKnowledgeLevel ?mKnLev) (ordinalNumber ?ordNum))
(student (ID ?sID) (knowledgeLevel ?sKnLev))
(passed_concepts  (ID ?one))
(concepts_added_in_plan  (ID ?caipID))
(test      (and    (<= ?mKnLev ?sKnLev)  (neq  ?cID ?caipID)   ))
(not (and (concepts (ID ?cID) (prerequisite $?first ?one $?rest)) (not (passed_concepts (ID ?one)))))
 =>
(retract ?fact1)
(call ?pok addConceptToPlan ?cID ?ordNum )

)

;;-------------------------------------------------------------;;
;;--- PART CONCERNING LESSON PLANNING ---;;
;;-------------------------------------------------------------;;

;;---- LESSON TEMPLATE---;;
(deftemplate lesson
(slot ordinalNumber (type INTEGER))
(slot ID )
(slot difficultyLevel (type INTEGER))
(slot belongs-to-concept ))

;;--- DEFQUERY FIND-LESSONS ---FIND ALL LESSONS THAT MATCH CURRENT CONCEPT 
 ---;;
;;--- AND STUDENT KNOWLEDGE (DIFFICULT LEVEL) ---;;
(defquery find-lessons
(declare (variables ?currConc ?diffLevel))
(lesson (difficultyLevel  ?diffLevel) ( belongs-to-concept  ?currConc)))

;;---
 DEFQUERY FIND-PARTICULAR-LESSON ---FIND LESSON THAT MATCH CURRENT CONCEPT AND  --;;
;;--- STUDENT KNOWLEDGE (DIFFICULT LEVEL) FOR PARTICULAR ORDINAL NUMBER ---;;

(defquery find-particular-lesson
(declare (variables ?currConc ?diffLevel ?ordNumb))
(lesson (ordinalNumber  ?ordNumb) (difficultyLevel  ?diffLevel) ( belongs-to-concept  ?currConc)))

;;-------------------------------------------------------------;;

;;--- PART CONCERNING PROCEDURE SET PLANNING ---;;

;;-------------------------------------------------------------;;



;;---- QUESTION TEMPLATE---;;
(deftemplate question
(slot conceptID)
(slot ID)
(slot group (type INTEGER))
(slot difficultyLevel (type INTEGER))
(slot related-to )
)

;;---- PASSEDD QUESTION TEMPLATE---;;
(deftemplate passed_question
(slot ID))

;;--- DEFQUERY FIND-QUESTIONS ---FIND ALL QUESTIONS IN ONE GROUP---;;
;;--- THAT MATCH CURRENT CONCEPT, DIFFICULTY LEVEL  ---;;
;;--- AND IS NOT ALREADY PASSEDD ---;;

(defquery find-questions
(declare (variables ?currConc ?group ?diffLev))
(question (conceptID  ?currConc) (group  ?group) (difficultyLevel  ?diffLev) (ID ?id))
(not (passed_question (ID ?id)))
)


(deffunction retract_question (?cId ?gr)
(bind ?it (run-query find_question_to_remove ?cId ?gr))
(while (?it hasNext)
(bind ?token (call ?it next))
(bind  ?fact (call ?token fact 2))
(retract ?fact))
)

(defquery find_question_to_remove
(declare (variables ?currConc ?gr))
(question (conceptID ?currConc)(ID ?qId) (group ?gr))
(passed_question (ID ?qId)))


