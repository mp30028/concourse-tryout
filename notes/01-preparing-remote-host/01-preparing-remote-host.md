## reset ssh
`ssh-keygen -R 65.109.234.59`

## renaming mount point of the mounted volume
[See this stack-overflow answer](https://stackoverflow.com/a/40118578/16868620)
<br/>
Step-1. `mkdir /mnt/zonesoft-volume-2`
<br/>
Step-2. `umount /mnt/HC_Volume_100564074`
<br/>
Step-3. Edit /etc/fstab `nano /etc/fstab`
![fstab-update](./fstab-update.png)
<br/>
Step-4. `mount /mnt/zonesoft-volume-2`
<br/>
Step-5. `rmdir /mnt/HC_Volume_100564074/`
<br/>


## checking the status of the docker daemon
run `service docker status`
<br/>
![checking-docker-status](./checking-docker-status.png)
<br/>

## create the zonesoft-admins group
run `groupadd zonesoft-admins`
<br/>

## check group is created
run `cat /etc/group`
<br/>
![check-groups](./check-groups.png)

## granting sudo access to a group (e.g. zonesoft-admins group)
For low down on sudo access (see this article)[https://ostechnix.com/allow-or-deny-sudo-access-to-a-group-in-linux/]
<br/>
Granting sudo access requires editing the sudoers file. However, because this is a critical file and if messed up can render a system unsuable it is not edited directly but using an intermediary tool such as visudo. 
<br/>
As further precaution the file is backed up using -a or --archive option. The -a option copies the file/directory with the same permission settings and metadata as the original. It preserve as much as possible of the structure and attributes of the original files in the copy: same directory tree, same file types, same contents, same metadata (times, permissions, extended attributes, etc.).
step-1. Backup the sudoers file with `cp --archive /etc/sudoers /etc/sudoers-backup-$(date +"%Y%m%d%H%M%S")`
<br/>
step-2. Check backup is there with `ls -ld /etc/sudoers*`<br/>
![check-backup-of-sudoers](./check-backup-of-sudoers.png)
</br>
step-3. Create zonesoft-uids file in the sudoers.d subfolder with `visudo -f /etc/sudoers.d/zonesoft-uids`. This file twill be included into sudoers automatically.
![sudoers-config](./sudoers-config.png)
<br/>


## creating a user with a default home directory and a default shell
run `useradd -m -s /usr/bin/bash -c "privileged admin account for mebs" mp30028` <br/>
the `-m` option creates a default home directory in `/home/mp30028` <br/>
the `-s /usr/bin/bash` option sets the default shell for the user to `/bin/bash` <br/>
the `-c "....."` option adds a comment <br/>
![check-user-setup](./check-user-setup.png)
<br/>

## setting the password for the user
run `passwd mp30028` and enter password at prompts

## adding users to the groups
run `usermod -a -G zonesoft-admins mp30028` to add to the zonesoft-admins group and so can have privileged access <br/>
run `usermod -a -G docker mp30028` to add to the docker group and so the account can manage docker and docker containers <br/>
![adding-accounts-to-groups](./adding-accounts-to-groups.png)
<br/>


## shell command to get timestamps 
run `date +%F-%H%M%S` <br/>
![shell-timestamp](./shell-timestamp.png) <br/>
<br/>
run `date +%s` to get epoch time value<br/>
![shell-timestamp-epoch-time-in-seconds](./shell-timestamp-epoch-time-in-seconds.png)
<br/>


## change ownership of a folder
run `sudo chown zsghwfuser:zonesoft-admins /installed-apps`<br/>
![change-directory-ownership](./change-directory-ownership.png)
<br/>

## Make the group owner of the directory maintain group ownership of any files created within it
`chmod g+s /installed-apps`

## Requesting and setting up SSL on the server
For instructions [see these notes](https://github.com/mp30028/notes/wiki/ssl)
<br/>

## For certificate renewals
run `sudo certbot certonly --standalone --preferred-challenges http -d mp30028.com` <br/>
However certbot by default setsup a scheduled job to renew the certs but it does not do the conversion to PKCS12 format needed by java applications. Which is why manual intervention is needed<br/>



#### Paths to private key and certificates
`/etc/letsencrypt/live/mp30028.com/fullchain.pem` <br/>
`/etc/letsencrypt/live/mp30028.com/privkey.pem` <br/>

#### convert the .pem files to PKCS12 format that the applications need
run `sudo openssl pkcs12 -export -out /etc/letsencrypt/live/mp30028.com/cert.p12 -in /etc/letsencrypt/live/mp30028.com/fullchain.pem -inkey /etc/letsencrypt/live/mp30028.com/privkey.pem`<br/>
When running the above command a prompt will come up to provide an export password which is currently set to *****************<br/>


