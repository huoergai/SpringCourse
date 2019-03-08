# Git 帐号密码配置

> 一次配置避免以后每次push时都需要输入帐号/密码.

1. 添加HOME环境变量.

   变量名: HOME

   变量值:%USERPROFILE%

2. 进入%HOME%所在目录:

   一般为: C:\Users\username.

3. 新建"_netrc"文件,文件内容:

   ```reStructuredText
   machine github.com
   login usernmae
   password password
   ```

> git init 
> git status
> git add aa.txt
> git commit -m "add file aa.txt"
> git add '*.txt'
> git commit -m 'add all txt files'
> git log

> git remote add origin https://github.com/try-git/try_git.git
> git push -u origin master

> git pull origin master
> git diff HEAD

> git add folders/bb.txt
> git diff --staged

> git reset folders/bb.txt
> git checkout -- bb.txt

> git branch new_branch
> git checkout new_branch
> git rm '*.txt'

> git checkout master
> git merge new_branch

> git branch -d new_branch
> git push