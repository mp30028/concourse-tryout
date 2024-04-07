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
