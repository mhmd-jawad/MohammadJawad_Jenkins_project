# Jenkins Python CI/CD Lab

## Project Structure
```
jenkins_project/
  app.py
  tests/test_app.py
  requirements.txt
  Jenkinsfile_FirstName_LastName
```

## Local Setup & Test (PowerShell)
```powershell
cd jenkins_project
python -m venv venv
.\venv\Scripts\Activate.ps1
pip install -r requirements.txt
flake8 app.py
pytest
coverage run -m pytest
coverage report
coverage html
bandit -r app.py
```

## Jenkins Pipeline Stages
- **Setup**: Create venv, install requirements
- **Lint**: flake8 style check
- **Test**: pytest unit tests
- **Coverage**: coverage.py report
- **Security Scan**: bandit scan
- **Deploy**: (placeholder)

## Jenkins Setup Steps
1. Install plugins: Git, Pipeline, SSH Agent, (optional: Blue Ocean)
2. Global Tool Config: Python (ensure python is in PATH)
3. Push this folder to a new GitHub repo
4. In Jenkins: New Item > Pipeline > Pipeline script from SCM > Git > your repo URL > Script Path: Jenkinsfile_FirstName_LastName
5. Build Now

## Screenshots for Report
- Jenkins plugins page (Git, Pipeline, SSH Agent)
- Job config (Pipeline from SCM)
- Build history and Console Output (showing all stages)
- Test Results (pytest output)
- Coverage report (console and htmlcov/)
- Bandit security scan output
- GitHub repo page

## Troubleshooting
- If venv activation fails, use `source venv/bin/activate` on Linux/macOS or `.\venv\Scripts\Activate.ps1` on Windows.
- If Jenkins can't find Python, ensure it's in PATH for the Jenkins user.
- If bandit/coverage/flake8 not found, check pip install and venv activation.
