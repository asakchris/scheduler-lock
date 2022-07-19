# Scheduler Lock
Run scheduled tasks at most once at the same time. Refer [ShedLock](https://github.com/lukas-krecan/ShedLock) for more details.

### Run in local
1. Create Postgres Database by running [docker-compose](docker-compose.yml) using `docker-compose up -d`
2. Use any Postgres Database client and run following DDL to create lock table:
   ```sql
   CREATE TABLE shedlock(
       name VARCHAR(64) NOT NULL,
       lock_until TIMESTAMP NOT NULL,
       locked_at TIMESTAMP NOT NULL,
       locked_by VARCHAR(255) NOT NULL,
       PRIMARY KEY (name)
   );
   ```
4. Run `Node-1` by running [this](.run/Application-1.run.xml) in IDE
5. Run `Node-2` by running [this](.run/Application-2.run.xml) in IDE
