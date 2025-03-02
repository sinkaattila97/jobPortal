### Requirements - Recruiter
- Post new job
- View our jobs
- View list of candidates that have applied for a job
- Edit profile and upload profile photo

### Requirements - Candidate
- Search for jobs
- Apply for a job
- View list of jobs that you (job candidate) has applied for
- Edit profile and upload profile photo
- Upload resumé / CV

### Key classes with supporting services and repositories
- ___HomeController___/Service/Repository (shows the home page)
- ___JobLocationController___/Service/Repository (Managing job locations)
- ___JobPostActivityController___/Service/Repository (Job posts and searching jobs)
- ___JobSeekerApplyController___/Service/Repository (Applying for jobs)
- ___JobSeekerProfileController___/Service/Repository (Managing job seeker profile)
- ___JobSeekerSaveController___/Service/Repository (Managing jobs that jobseeker has applied for)
- ___RecruiterProfileController___/Service/Repository (Managing recruiter profile)
- ___UsersController___/Service/Repository (Login/Logout/Register)


### DB entities:
- ___JobCompany___ (A job company: name, logo etc)
- ___JobPostActivity___ (A job post: title, description, salary, remote etc)
- ___JobSeekerApply___ (Tracks the jobseekers who have applied for a job)
- ___JobSeekerProfile___ (Info about jobseeker: name, city, state, skills, etc)
- ___JobSeekerSave___ (Tracks the jobs a jobseeker has applied to)
- ___RecruiterProfile___ (Info about recruiter: name, city, state, company, etc)
- ___Skills___ (Info about a skill: name, experience level, years of experience)
- ___Users___ (Info about a user: email, password etc)
- ___UsersType___ (Type/role of user: recruiter or jobseeker)

### DB layout:
![DB DIAGRAM](/assets/images/db_diagram.png)

### Development Road map:
1. User Registration -> Login/Logout
   2. Setup the project
   3. Create project template files(HTML, JS, CSS)
   4. Database Entities for Users and UserTypes
   5. User Registration: Repositories and Controllers
   6. Create profiles for Recruiter and JobSeeker
   7. Add support for Skills to JobSeekers
2. Recruiter Profile 
    1. Create RecruiterProfile  - controller and service
    2. Add support for file upload of recruiter profile image
    3. Update dashboard to display recruiter profile image
3. Recruiter New Job
   4. Create JPA  entities for JobLocation, JobComapny, JobPostActivity
   5. JobPostActivityController: enhance for posting a new job
   6. Integrate HTML form for popsting a new job
5. Recruiter Dashboard
3. Candidate Profile -> Candidate Dashboard -> Candidate Apply