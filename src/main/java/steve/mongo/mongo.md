## mongo
### 设置master为本地
```
reconfg = rs.conf()
reconfg.members = [{_id:0, "host": "127.0.0.1:27017"}]
rs.reconfig(reconfg, {force:true})
```
