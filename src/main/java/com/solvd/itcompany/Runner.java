package com.solvd.itcompany;


import com.solvd.itcompany.employees.*;
import com.solvd.itcompany.enums.ExperienceLevel;
import com.solvd.itcompany.enums.ProjectStatus;
import com.solvd.itcompany.exceptions.EmployeeShortageException;
import com.solvd.itcompany.exceptions.EmptyEmployeeListException;
import com.solvd.itcompany.exceptions.InsufficientBudgetException;
import com.solvd.itcompany.exceptions.InvalidClientException;
import com.solvd.itcompany.generics.EmployeeHashmap;
import com.solvd.itcompany.generics.LinkedListProject;
import com.solvd.itcompany.lambdas.ProjectInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.TriConsumer;

import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.solvd.itcompany.generics.ListOfTasks.createTasks;
import static com.solvd.itcompany.generics.ProjectPriority.prioritizeProjects;
import static com.solvd.itcompany.generics.ProjectTracker.removeProject;


public class Runner<T> {
    private static final Logger logger = LogManager.getLogger(Runner.class);


    public static <T> void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {

        // creating the client for the IT company
        Client client1 = new Client("Paul's Coffee Shop", "create an app for the coffee shop", 2);

        //creating more clients
        Client client2 = new Client("Kelly's Pet Shop", "create an app for the pet shop", 5);
        Client client3 = new Client("Dave's Bakery Shop", "create an app for the bakery shop", 10);

        List<Client> allClients = new ArrayList<>(
                Arrays.asList(client1, client2, client3)
        );

        logger.info("\n---------------------List of Clients:---------------------");
        // lambda 1 using java.util.function package
        Function<Client, String> clientToName = c -> c.getName();
        List<String> clientNames = allClients.stream().map(clientToName).collect(Collectors.toList());
        logger.info(clientNames);


        logger.info("\n---------------------Clients that have been in business for more than 3 years:---------------------");
        // lambda 2 using java.util.function package
        Predicate<Client> yearsInBusiness = (Client c) -> c.getYearsInBusiness() > 3;
        allClients.stream().filter(yearsInBusiness).map(clientToName).forEach(logger::info);


        logger.info("\n---------------------List of Clients Ideas:---------------------");
        // lambda 3 using java.util.function package
        Consumer<Client> printIdea = (Client c) -> logger.info(c.getIdea());
        allClients.forEach(printIdea);



        try{
            Client client4 = new Client("Scooters Tea Shop", "create an app for the tea shop");
        }
        catch(InvalidClientException e){
            logger.error(e.getMessage());
        }

        // creating the project the client wants done
        Project project1 = new Project(client1, com.solvd.itcompany.enums.Service.APP_DEVELOPMENT.getPrice(), 1500.00, com.solvd.itcompany.enums.Service.APP_DEVELOPMENT, ProjectStatus.NEW);

        // creating more projects
        Project project2 = new Project(client2, com.solvd.itcompany.enums.Service.APP_DEVELOPMENT.getPrice(), 2500.00, com.solvd.itcompany.enums.Service.APP_DEVELOPMENT, ProjectStatus.NEW);

        Project project3 = new Project(client3, com.solvd.itcompany.enums.Service.APP_DEVELOPMENT.getPrice(), 3000.00, com.solvd.itcompany.enums.Service.APP_DEVELOPMENT, ProjectStatus.NEW);

        ArrayList<Project> firstProject = new ArrayList<>(
                Arrays.asList(project1)
        );

        ArrayList<Project> allProjects = new ArrayList<>(
                Arrays.asList(project1, project2, project3)
        );

        logger.info("\n---------------------Number of Projects:---------------------");
        // stream 1
        long numOfProjects = allProjects.stream()
                .limit(5)
                .count();
        logger.info(numOfProjects);


        logger.info("\n---------------------Highest Paying Clients:---------------------");
        // stream 3
        long highestPayingClient = allProjects.stream()
                .filter(p -> p.getBudget() > 2000.00)
                .count();

        logger.info(highestPayingClient);

        logger.info("\n---------------------Total Project Profits:---------------------");
        // stream 4
        double totalProfit = allProjects.stream()
                        .mapToDouble(Project::getBudget)
                                .sum();

        logger.info("Total Profit: " + totalProfit);



        logger.info("\n---------------------Client Information:---------------------");
        // custom lambda function 1
        ProjectInformation<Project> projectInformation = (List<Project> projects) -> {
            projects.forEach(project -> {
                logger.info("Client Name: " + project.getClient().getName());
                logger.info("Client Idea: " + project.getClient().getIdea());
                logger.info("Years in Business: " + project.getClient().getYearsInBusiness());
                logger.info("Client Budget: " + project.getBudget());
                logger.info("Client Project Status: " + project.getProjectStatus());
            });
        };

        Project.printClientInformation(allProjects, projectInformation);



        // adding the projects to a linked list
        LinkedList<Project> projectList = new LinkedList<>();
        projectList.add(project1);
        LinkedListProject<Project> listOfProjects = new LinkedListProject<>();
        listOfProjects.printListOfProjects(projectList);


        // creating requirements for the application
        ArrayList <String> requirements = new ArrayList<String>(
                Arrays.asList("Users can order coffee", "Users can track loyalty points", "Users can interact with community"));
        Requirement.setFeatures(requirements);
        IFulfillRequirements.reviewRequirements();


        // creating a project manager
        ArrayList <String> tools = new ArrayList<String>(
                Arrays.asList("Gantt chart", "Communications plan"));
        ProjectManager projectManager1 = new ProjectManager("Cameron", false, tools, "Bachelors Degree in Business Administration", "Manager", ExperienceLevel.MID_LEVEL);


        // creating a designer
        ArrayList <String> designerSoftware = new ArrayList<String>(
                Arrays.asList("Andromo", "BuildFire"));
        Designer designer1 = new Designer("Lily", false, designerSoftware, "Bachelors Degree in Graphic Design", "Designer", ExperienceLevel.ENTRY_LEVEL);


        // creating a backend engineer
        ArrayList <String> backendLanguages = new ArrayList<String>(
                Arrays.asList("Java", "PHP", "JavaScript"));
        BackendEngineer backendEngineer1 = new BackendEngineer("Tom", false, backendLanguages, "Bachelors Degree in Computer Science", "Backend", ExperienceLevel.MID_LEVEL);


        // creating a frontend engineer
        ArrayList <String> frontendLanguages = new ArrayList<String>(
                Arrays.asList("HTML", "CSS", "React"));
        FrontendEngineer frontendEngineer1 = new FrontendEngineer("Pam", false, frontendLanguages, "Frontend Bootcamp", "Frontend", ExperienceLevel.MID_LEVEL);


        // creating an IOS developer
        ArrayList <String> iosLanguages = new ArrayList<String>(
                Arrays.asList("Swift", "Objective-C"));
        IOSDeveloper iosDeveloper1 = new IOSDeveloper("Kevin", false, iosLanguages, "Mobile Development Bootcamp", "IOS", ExperienceLevel.SENIOR_LEVEL);


        // creating a quality analyst
        ArrayList <String> qualityTools = new ArrayList<String>(
                Arrays.asList("Java", "Maven", "Cucumber"));
        QualityAnalyst qualityAnalyst1 = new QualityAnalyst("David", false, qualityTools, "Bachelors Degree in Information Technology", "Quality", ExperienceLevel.ENTRY_LEVEL);


        //creating a marketing manager
        ArrayList <String> marketingStrategy = new ArrayList<String>(
                Arrays.asList("organic social media", "email promotion", "paid social media"));
        MarketingManager marketingManager1 = new MarketingManager("Carl", false, marketingStrategy, "Bachelors Degree in Marketing", "Marketing", ExperienceLevel.SENIOR_LEVEL);


        // creating the design department
        ArrayList <Employee> designEmployees = new ArrayList<Employee>();
        DesignDepartment designDepartment1 = new DesignDepartment();
        designDepartment1.setDesignEmployees(designEmployees);
        designDepartment1.setDepartmentName("Design Department");

        
        // creating the engineering department
        ArrayList <Employee> engineeringEmployees = new ArrayList<Employee>(
                Arrays.asList(backendEngineer1, frontendEngineer1, iosDeveloper1, qualityAnalyst1)
        );
        EngineeringDepartment engineeringDepartment1 = new EngineeringDepartment();
        engineeringDepartment1.setEngineeringEmployees(engineeringEmployees);
        engineeringDepartment1.setDepartmentName("Engineering Department");


        // creating the marketing department
        ArrayList <Employee> marketingEmployees = new ArrayList<Employee>();
        MarketingDepartment marketingDepartment1 = new MarketingDepartment();
        marketingDepartment1.setMarketingEmployees(marketingEmployees);
        marketingDepartment1.setDepartmentName("Marketing Department");

        // creating a department arraylist
        ArrayList <Department> departments = new ArrayList<>(
                Arrays.asList(designDepartment1, engineeringDepartment1, marketingDepartment1)
        );

        logger.info("\n---------------------Checking if all projects are within the IT company's budget:---------------------");
        // lambda 4 using java.util.function package
        BiPredicate<Project, Project> isEqual = (Project p1, Project p2) -> p1.getBudget() >= p1.getPrice();
        boolean project_1 = isEqual.test(project1, project1);
        logger.info("Paul's Coffee Shop: " + project_1);

        boolean project_2 = isEqual.test(project2, project2);
        logger.info("Kelly's Pet Shop: " + project_2);

        boolean project_3 = isEqual.test(project3, project3);
        logger.info("Dave's Bakery Shop: " + project_3);


        logger.info("\n---------------------Departments in IT Company:---------------------");
        // lambda 5 using java.util.function package
        TriConsumer<Department, Department, Department> printDepartments = (d1, d2, d3) -> {
            logger.info("Department 1: " + d1.getDepartmentName());
            logger.info("Department 2: " + d2.getDepartmentName());
            logger.info("Department 3: " + d3.getDepartmentName());
        };

        printDepartments.accept(designDepartment1, engineeringDepartment1, marketingDepartment1);


        logger.info("\n---------------------Mid-level Engineers:---------------------");
        // stream 2
        List<Employee> engDepartment = engineeringEmployees.stream()
                .filter(e -> e.getExperienceLevel() == ExperienceLevel.MID_LEVEL)
                .collect(Collectors.toList());

        logger.info(engDepartment);

        // creating an employee arraylist
        ArrayList <Employee> allEmployees = new ArrayList<>(
                Arrays.asList(projectManager1, designer1, backendEngineer1, frontendEngineer1, iosDeveloper1, qualityAnalyst1, marketingManager1)
        );
        Department.setEmployees(allEmployees);


        logger.info("\n---------------------Employees With Bachelor Degrees:---------------------");
        // custom lambda function 2
        Employee.printFilteredEmployees(allEmployees, (Employee e) -> e.getCertification().startsWith("Bachelors"));


        logger.info("\n---------------------Team Members Names:---------------------");
        // custom lambda function 3
        Employee.printEmployeeName(allEmployees, (Employee e) -> e.getName());



        // adding employees to a hashmap
        EmployeeHashmap<String, Employee> employeeList = new EmployeeHashmap<String, Employee>();
        employeeList.put("Project Manager", projectManager1);
        employeeList.put("Designer", designer1);
        employeeList.put("Backend Engineer", backendEngineer1);
        employeeList.put("Frontend Engineer", frontendEngineer1);
        employeeList.put("IOS Developer", iosDeveloper1);
        employeeList.put("Quality Analyst", qualityAnalyst1);
        employeeList.put("Marketing Manager", marketingManager1);
        employeeList.listOfEmployees(employeeList);



        // creating an IT company
        ITCompany ITLab = new ITCompany("IT Lab", allEmployees, firstProject, ProjectStatus.NEW);

        // intro for the creation of the project
        ITLab.intro();

        // creating the application
        try{
            ITLab.assignProject(project1, allEmployees, ProjectStatus.NEW);
        }
        catch(EmptyEmployeeListException | InsufficientBudgetException e){
            logger.error(e.getMessage());
        }

        try{
            ITLab.projectCreated(project1, allEmployees);
        }
        catch(EmptyEmployeeListException | EmployeeShortageException e){
            logger.error(e.getMessage());
        }



        // checking the status of the project and removing it if the status is set to complete
        ArrayList<Project> listOfCurrentProjects = new ArrayList<>();
        listOfCurrentProjects.add(project1);
        listOfCurrentProjects.add(project2);
        listOfCurrentProjects.add(project3);
        removeProject(listOfCurrentProjects);


        // creating tasks for the project
        HashSet<String> tasks = new HashSet<>();
        tasks.add("Create the management plan for the project");
        tasks.add("Create the design of the application");
        tasks.add("Create the backend");
        tasks.add("Create the frontend");
        tasks.add("Create the mobile application");
        tasks.add("Test the application");
        tasks.add("Create the marketing strategy for the application");
        createTasks(tasks);

        logger.info("\n---------------------The First Task in Every Project:---------------------");
        // stream 5
        Optional<String> firstTask = tasks.stream()
                .filter(s -> s.contains("management"))
                .findFirst();

        if (firstTask.isPresent()){
            logger.info(firstTask.get());
        }


        // creating a priority list of projects
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Project1");
        priorityQueue.add("Project2");
        priorityQueue.add("Project3");
        prioritizeProjects(priorityQueue);



        // release the application
        ArrayList <String> userFeedback = new ArrayList<String>(
                Arrays.asList("Great app!", "Horrible user experience.", "I order coffee on this app all the time!"));
        Release.setUserFeedback(userFeedback);
        ITLab.releaseApp();

        logger.info("\n---------------------Bad Reviews:---------------------");
        // stream 6
        List<String> onlyBadReviews = userFeedback.stream()
                .filter(r -> r.contains("Horrible"))
                .collect(Collectors.toList());

        logger.info(onlyBadReviews);

        ITLab.maintenance();

        logger.info("\n\n\n---------------------Next Projects To Do:---------------------");
        // stream 7
        List<Project> nextProjects = listOfCurrentProjects.stream()
                .skip(1)
                .collect(Collectors.toList());

        logger.info(nextProjects);


        logger.info("\n\n\n---------------------Reflection:---------------------");
        // reflection

        // getting the class object
        Class<?> clsITCompany = Class.forName("com.solvd.itcompany.ITCompany");

        // getting the constructor of the class
        Constructor<?> constructorOfClass = clsITCompany.getConstructor();

        logger.info("The name of the constructor: " + constructorOfClass.getName());

        // getting the fields of the class
        logger.info("The fields of the class: \n");
        Field[] itcompanyFields = clsITCompany.getDeclaredFields();

        for (Field field : itcompanyFields){
            logger.info(field.getName());
            int fieldModifiers = field.getModifiers();
            logger.info("Field Modifiers: " + Modifier.toString(fieldModifiers));
        }

        // getting the methods
        Method[] methods = clsITCompany.getDeclaredMethods();

        for (Method method : methods){
            int methodModifiers = method.getModifiers();
            logger.info("Method Modifiers: " + Modifier.toString(methodModifiers));

            // getting the return type
            Class<?> returnType = method.getReturnType();
            logger.info("Return Type: " + returnType.getName());

            // getting the method name
            logger.info("Method name: " + method.getName());

            // getting the parameters
            Class[] parameterTypes = method.getParameterTypes();
            logger.info("Parameters: ");
            for (Class parameterType : parameterTypes){
                logger.info(" " + parameterType.getName());
            }
        }

        // getting a class object
        Object obj = clsITCompany.getDeclaredConstructor().newInstance();

        // getting the method
        Method method = clsITCompany.getDeclaredMethod("releaseApp");

        // calling the method
        logger.info("Result of method call: ");
        Object result = method.invoke(obj);


        


    }
}
