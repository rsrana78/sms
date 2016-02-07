
--- @author Rana

CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `day` int(11) NOT NULL,
  `date` date NOT NULL,
  `isHoliday` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `employeeType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
);

CREATE TABLE `qualification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(100) NOT NULL,
  `ownerName` varchar(45) NOT NULL,
  `emailAddress` varchar(45) NOT NULL,
  `monogram` varchar(100) NOT NULL,
  `startedDate` date NOT NULL,
  `entryDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE `campus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolId` int(11) NOT NULL,
  `contact1` varchar(11) NOT NULL,
  `contact2` varchar(11) NOT NULL,
  `address` varchar(250) NOT NULL,
  `principal` int(11),
  `principalContact` varchar(11),
  `campusName` varchar(150) NOT NULL,
  `startingDate` date NOT NULL,
  `entryDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_campus_1_idx` (`schoolId`),
  KEY `fk_campus_2_idx` (`principal`),
  CONSTRAINT `fk_campus_1` FOREIGN KEY (`schoolId`) REFERENCES `school` (`id`),
  CONSTRAINT `fk_campus_2` FOREIGN KEY (`principal`) REFERENCES `employee` (`id`)
);

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `fatherName` varchar(50) NOT NULL,
  `school` int(11) NOT NULL,
  `cnic` varchar(13) NOT NULL,
  `contactNumber` varchar(13) NOT NULL,
  `address` varchar(150) NOT NULL,
  `joiningDate` date NOT NULL,
  `employeeType` int(11) NOT NULL,
  `qualification` int(11) NOT NULL,
  `terminationDate` date DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  `entryDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `serving` tinyint(1) NOT NULL DEFAULT '1',
  `imagePath` varchar(45) NOT NULL,
  `salary` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_1_idx` (`employeeType`),
  KEY `fk_employee_2_idx` (`qualification`),
  KEY `fk_employee_3_idx` (`school`),
  CONSTRAINT `fk_employee_1` FOREIGN KEY (`employeeType`) REFERENCES `employeeType` (`id`),
  CONSTRAINT `fk_employee_2` FOREIGN KEY (`qualification`) REFERENCES `qualification` (`id`),
  CONSTRAINT `fk_employee_3` FOREIGN KEY (`school`) REFERENCES `campus` (`id`)
);

CREATE TABLE `attendanceDetailEmployee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance` int(11) NOT NULL,
  `employee` int(11) NOT NULL,
  `present` tinyint(1) NOT NULL DEFAULT '0',
  `leave` tinyint(1) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_attendanceDetailEmployee_1_idx` (`attendance`),
  KEY `fk_attendanceDetailEmployee_2_idx` (`employee`),
  CONSTRAINT `fk_attendanceDetailEmployee_1` FOREIGN KEY (`attendance`) REFERENCES `attendance` (`id`),
  CONSTRAINT `fk_attendanceDetailEmployee_2` FOREIGN KEY (`employee`) REFERENCES `employee` (`id`)
);

CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `schoolClasses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school` int(11) NOT NULL,
  `class` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_schoolClasses_1_idx` (`school`),
  KEY `fk_schoolClasses_2_idx` (`class`),
  CONSTRAINT `fk_schoolClasses_1` FOREIGN KEY (`school`) REFERENCES `campus` (`id`),
  CONSTRAINT `fk_schoolClasses_2` FOREIGN KEY (`class`) REFERENCES `class` (`id`)
);

CREATE TABLE `sections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `incharge` int(11) NOT NULL,
  `startingDate` date NOT NULL,
  `sessionYear` varchar(45) NOT NULL,
  `sessionEnd` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_sections_1_idx` (`incharge`),
  KEY `fk_sections_2_idx` (`class`),
  CONSTRAINT `fk_sections_1` FOREIGN KEY (`incharge`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_sections_2` FOREIGN KEY (`class`) REFERENCES `schoolClasses` (`id`)
);

CREATE TABLE `studentClassGroup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` int(11) NOT NULL,
  `groupName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_studentClassGroup_1_idx` (`class`),
  CONSTRAINT `fk_studentClassGroup_1` FOREIGN KEY (`class`) REFERENCES `schoolClasses` (`id`)
);

CREATE TABLE `students` (
  `name` varchar(45) NOT NULL,
  `fatherName` varchar(45) NOT NULL,
  `registrationNumber` varchar(45) NOT NULL,
  `fatherContactNumber` varchar(11) NOT NULL,
  `address` varchar(150) NOT NULL,
  `school` int(11) NOT NULL,
  `class` int(11) NOT NULL,
  `admissionDate` date NOT NULL,
  `admissionBy` int(11) NOT NULL,
  `photoPath` varchar(45) NOT NULL,
  `passedOut` tinyint(1) DEFAULT '0',
  `hasLeft` tinyint(1) DEFAULT '0',
  `admissionCancel` tinyint(1) DEFAULT '0',
  `reason` varchar(45) DEFAULT NULL,
  `studentClassGroup` int(11) DEFAULT NULL,
  PRIMARY KEY (`registrationNumber`),
  KEY `fk_students_1_idx` (`school`),
  KEY `fk_students_2_idx` (`class`),
  KEY `fk_students_3_idx` (`admissionBy`),
  KEY `fk_students_4_idx` (`studentClassGroup`),
  CONSTRAINT `fk_students_1` FOREIGN KEY (`school`) REFERENCES `campus` (`id`),
  CONSTRAINT `fk_students_2` FOREIGN KEY (`class`) REFERENCES `sections` (`id`),
  CONSTRAINT `fk_students_3` FOREIGN KEY (`admissionBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `fk_students_4` FOREIGN KEY (`studentClassGroup`) REFERENCES `studentClassGroup` (`id`)
);

CREATE TABLE `attendanceDetailStudent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance` int(11) NOT NULL,
  `student` varchar(45) NOT NULL,
  `present` tinyint(1) NOT NULL DEFAULT '0',
  `leave` tinyint(1) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_attendanceDetail_1_idx` (`attendance`),
  KEY `fk_attendanceDetail_2_idx` (`student`),
  CONSTRAINT `fk_attendanceDetailStudent_1` FOREIGN KEY (`attendance`) REFERENCES `attendance` (`id`),
  CONSTRAINT `fk_attendanceDetailStudent_2` FOREIGN KEY (`student`) REFERENCES `students` (`registrationNumber`)
);

CREATE TABLE `classDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sectionName` int(11) NOT NULL,
  `student` varchar(45) NOT NULL,
  `rollNumber` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_classDetail_1_idx` (`student`),
  KEY `fk_classDetail_2_idx` (`sectionName`),
  CONSTRAINT `fk_classDetail_1` FOREIGN KEY (`student`) REFERENCES `students` (`registrationNumber`),
  CONSTRAINT `fk_classDetail_2` FOREIGN KEY (`sectionName`) REFERENCES `sections` (`id`)
);

CREATE TABLE `exams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` year(4) NOT NULL,
  `examName` varchar(45) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `examEnd` tinyint(1) NOT NULL DEFAULT '0',
  `resultAnnounced` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `elective` tinyint(1) NOT NULL,
  `compulsory` tinyint(1) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_subjects_1_idx` (`class`),
  CONSTRAINT `fk_subjects_1` FOREIGN KEY (`class`) REFERENCES `schoolClasses` (`id`)
);

CREATE TABLE `dateSheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam` int(11) NOT NULL,
  `class` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dateSheet_1_idx` (`exam`),
  KEY `fk_dateSheet_2_idx` (`class`),
  CONSTRAINT `fk_dateSheet_1` FOREIGN KEY (`exam`) REFERENCES `exams` (`id`),
  CONSTRAINT `fk_dateSheet_2` FOREIGN KEY (`class`) REFERENCES `schoolClasses` (`id`)
);

CREATE TABLE `dateSheetDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateSheet` int(11) NOT NULL,
  `subject` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dateSheetDetail_1_idx` (`dateSheet`),
  KEY `fk_dateSheetDetail_2_idx` (`subject`),
  CONSTRAINT `fk_dateSheetDetail_1` FOREIGN KEY (`dateSheet`) REFERENCES `dateSheet` (`id`),
  CONSTRAINT `fk_dateSheetDetail_2` FOREIGN KEY (`subject`) REFERENCES `subjects` (`id`)
);

CREATE TABLE `examResult` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam` int(11) NOT NULL,
  `class` int(11) NOT NULL,
  `first` int(11) NOT NULL,
  `second` int(11) NOT NULL,
  `third` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_examResult_1_idx` (`exam`),
  KEY `fk_examResult_2_idx` (`class`),
  CONSTRAINT `fk_examResult_1` FOREIGN KEY (`exam`) REFERENCES `exams` (`id`),
  CONSTRAINT `fk_examResult_2` FOREIGN KEY (`class`) REFERENCES `sections` (`id`)
);

CREATE TABLE `examResultDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examResult` int(11) NOT NULL,
  `subject` int(11) NOT NULL,
  `subjectTeacher` int(11) NOT NULL,
  `totalMarks` int(5) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_examResultDetail_1_idx` (`examResult`),
  KEY `fk_examResultDetail_2_idx` (`subject`),
  KEY `fk_examResultDetail_3_idx` (`subjectTeacher`),
  CONSTRAINT `fk_examResultDetail_1` FOREIGN KEY (`examResult`) REFERENCES `examResult` (`id`),
  CONSTRAINT `fk_examResultDetail_2` FOREIGN KEY (`subject`) REFERENCES `subjects` (`id`),
  CONSTRAINT `fk_examResultDetail_3` FOREIGN KEY (`subjectTeacher`) REFERENCES `employee` (`id`)
);

CREATE TABLE `examResultDetailMarks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examResultDetail` int(11) NOT NULL,
  `student` varchar(45) NOT NULL,
  `marksObtained` int(11) NOT NULL,
  `absent` tinyint(1) NOT NULL DEFAULT '0',
  `remarks` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_examResultDetailMarks_1_idx` (`examResultDetail`),
  KEY `fk_examResultDetailMarks_2_idx` (`student`),
  CONSTRAINT `fk_examResultDetailMarks_1` FOREIGN KEY (`examResultDetail`) REFERENCES `examResultDetail` (`id`),
  CONSTRAINT `fk_examResultDetailMarks_2` FOREIGN KEY (`student`) REFERENCES `students` (`registrationNumber`)
);

CREATE TABLE `fee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` int(11) NOT NULL,
  `fee` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_fee_1_idx` (`class`),
  CONSTRAINT `fk_fee_1` FOREIGN KEY (`class`) REFERENCES `schoolClasses` (`id`)
);

CREATE TABLE `fine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student` varchar(45) NOT NULL,
  `amount` decimal(10,0) NOT NULL,
  `reason` varchar(150) NOT NULL,
  `submitted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_fine_1_idx` (`student`),
  CONSTRAINT `fk_fine_1` FOREIGN KEY (`student`) REFERENCES `students` (`registrationNumber`)
);

CREATE TABLE `monthlyFee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(45) NOT NULL,
  `month` varchar(45) NOT NULL,
  `entryDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lastDateOfFeeSubmit` date NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `monthlyFeeDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `monthlyFee` int(11) NOT NULL,
  `student` varchar(45) NOT NULL,
  `totalFee` decimal(10,0) NOT NULL,
  `depositedFee` decimal(10,0) NOT NULL,
  `completePaid` tinyint(1) NOT NULL,
  `late` tinyint(1) NOT NULL,
  `message` varchar(45) DEFAULT NULL,
  `totalDays` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_monthlyFeeDetail_1_idx` (`monthlyFee`),
  KEY `fk_monthlyFeeDetail_2_idx` (`student`),
  CONSTRAINT `fk_monthlyFeeDetail_1` FOREIGN KEY (`monthlyFee`) REFERENCES `monthlyFee` (`id`),
  CONSTRAINT `fk_monthlyFeeDetail_2` FOREIGN KEY (`student`) REFERENCES `students` (`registrationNumber`)
);

CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` year(4) NOT NULL,
  `month` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `salaryDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salary` int(11) NOT NULL,
  `employee` int(11) NOT NULL,
  `amountReceived` decimal(10,0) NOT NULL,
  `received` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salaryDetail_1_idx` (`salary`),
  KEY `fk_salaryDetail_2_idx` (`employee`),
  CONSTRAINT `fk_salaryDetail_1` FOREIGN KEY (`salary`) REFERENCES `salary` (`id`),
  CONSTRAINT `fk_salaryDetail_2` FOREIGN KEY (`employee`) REFERENCES `employee` (`id`)
);

CREATE TABLE `studentClassGroupDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group` int(11) NOT NULL,
  `subject` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_studentClassGroupDetail_1_idx` (`group`),
  KEY `fk_studentClassGroupDetail_2_idx` (`subject`),
  CONSTRAINT `fk_studentClassGroupDetail_1` FOREIGN KEY (`group`) REFERENCES `studentClassGroup` (`id`),
  CONSTRAINT `fk_studentClassGroupDetail_2` FOREIGN KEY (`subject`) REFERENCES `subjects` (`id`)
);

CREATE TABLE `tests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` int(11) NOT NULL,
  `subject` int(11) NOT NULL,
  `date` date NOT NULL,
  `teacher` int(11) NOT NULL,
  `totalMarks` int(11) NOT NULL,
  `resultAnnounced` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_tests_1_idx` (`class`),
  KEY `fk_tests_2_idx` (`subject`),
  KEY `fk_tests_3_idx` (`teacher`),
  CONSTRAINT `fk_tests_1` FOREIGN KEY (`class`) REFERENCES `sections` (`id`),
  CONSTRAINT `fk_tests_2` FOREIGN KEY (`subject`) REFERENCES `subjects` (`id`),
  CONSTRAINT `fk_tests_3` FOREIGN KEY (`teacher`) REFERENCES `employee` (`id`)
);

CREATE TABLE `testResult` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test` int(11) NOT NULL,
  `student` varchar(45) NOT NULL,
  `obtainedMarks` int(11) NOT NULL,
  `absent` tinyint(1) NOT NULL,
  `remarks` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_testResult_1_idx` (`test`),
  KEY `fk_testResult_2_idx` (`student`),
  CONSTRAINT `fk_testResult_1` FOREIGN KEY (`test`) REFERENCES `tests` (`id`),
  CONSTRAINT `fk_testResult_2` FOREIGN KEY (`student`) REFERENCES `students` (`registrationNumber`)
);

CREATE TABLE `timeTable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_timeTable_1_idx` (`class`),
  CONSTRAINT `fk_timeTable_1` FOREIGN KEY (`class`) REFERENCES `sections` (`id`)
);

CREATE TABLE `timeTableDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timeTable` int(11) NOT NULL,
  `lectureName` varchar(45) NOT NULL,
  `subject` int(11) NOT NULL,
  `teacher` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_timeTableDetail_1_idx` (`timeTable`),
  KEY `fk_timeTableDetail_2_idx` (`subject`),
  KEY `fk_timeTableDetail_3_idx` (`teacher`),
  CONSTRAINT `fk_timeTableDetail_1` FOREIGN KEY (`timeTable`) REFERENCES `timeTable` (`id`),
  CONSTRAINT `fk_timeTableDetail_2` FOREIGN KEY (`subject`) REFERENCES `subjects` (`id`),
  CONSTRAINT `fk_timeTableDetail_3` FOREIGN KEY (`teacher`) REFERENCES `employee` (`id`)
);

CREATE TABLE `usersLogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `fullName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(450) NOT NULL,
  `schoolCampus` int(11) NOT NULL,
  `superUser` tinyint(1) DEFAULT NULL,
  `school` int(11) DEFAULT NULL,
  `student` tinyint(1) DEFAULT NULL,
  `employee` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE `school` 
ADD COLUMN `ownerImg` VARCHAR(45) NOT NULL AFTER `ownerName`;
