package com.chrisy.casemanager.data


object SampleData {
    val sampleEmployees = listOf(
        Employee(name = "Alice Walker", role = "Lawyer", contact = "alice@example.com"),
        Employee(name = "Bob Smith", role = "Judge", contact = "bob@example.com"),
        Employee(name = "Catherine Lee", role = "Clerk", contact = "catherine@example.com"),
        Employee(name = "David Chen", role = "Paralegal", contact = "david@example.com"),
        Employee(name = "Eva Adams", role = "Secretary", contact = "eva@example.com"),
        Employee(name = "Frank Moore", role = "Investigator", contact = "frank@example.com"),
        Employee(name = "Grace King", role = "Lawyer", contact = "grace@example.com"),
        Employee(name = "Henry Young", role = "Judge", contact = "henry@example.com"),
        Employee(name = "Isla Stone", role = "Intern", contact = "isla@example.com"),
        Employee(name = "Jack Wilson", role = "Consultant", contact = "jack@example.com")
    )

    val sampleCases = listOf(
        Case(name = "State vs John", caseType = "Criminal", date = "2024-01-01", lawyer = "Alice Walker", judge = "Bob Smith", status = "Open"),
        Case(name = "Estate of Mary", caseType = "Probate", date = "2024-02-01", lawyer = "Grace King", judge = "Henry Young", status = "Closed"),
        Case(name = "Smith v. Jones", caseType = "Civil", date = "2024-03-01", lawyer = "Alice Walker", judge = "Bob Smith", status = "Pending"),
        Case(name = "Company v. Contractor", caseType = "Labor", date = "2024-04-01", lawyer = "Grace King", judge = "Henry Young", status = "Open"),
        Case(name = "City of Springfield", caseType = "Environmental", date = "2024-05-01", lawyer = "David Chen", judge = "Bob Smith", status = "Appealed"),
        Case(name = "Williams v. TechCorp", caseType = "IP", date = "2024-06-01", lawyer = "Alice Walker", judge = "Henry Young", status = "Open"),
        Case(name = "Doe v. Hospital", caseType = "Medical", date = "2024-07-01", lawyer = "Grace King", judge = "Bob Smith", status = "Closed"),
        Case(name = "Johnson v. State", caseType = "Constitutional", date = "2024-08-01", lawyer = "Frank Moore", judge = "Henry Young", status = "Pending"),
        Case(name = "Investor v. Broker", caseType = "Finance", date = "2024-09-01", lawyer = "Alice Walker", judge = "Bob Smith", status = "Appealed"),
        Case(name = "Public vs Developer", caseType = "Zoning", date = "2024-10-01", lawyer = "Eva Adams", judge = "Henry Young", status = "Open")
    )
}
