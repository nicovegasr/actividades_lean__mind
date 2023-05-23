import * as cors from 'cors';
import * as express from 'express';

import cookieParser = require('cookie-parser');

import { stablishDatabaseConection } from '../database/database';
import { userRoute } from '../user/infrastructure/controllers/userSaveController';

const app = express();

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({extended:true}));
app.use(cookieParser());

app.use("/", userRoute);

const server = app.listen(4000, () => {
  console.log(`Server is up on port 4000`);
});

stablishDatabaseConection()
module.exports = {app, server};