"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const cors = require("cors");
const express = require("express");
const cookieParser = require("cookie-parser");
const database_1 = require("../database/database");
const userSaveController_1 = require("../user/infrastructure/controllers/userSaveController");
const app = express();
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cookieParser());
app.use("/", userSaveController_1.userRoute);
const server = app.listen(4000, () => {
    console.log(`Server is up on port 4000`);
});
(0, database_1.stablishDatabaseConection)();
module.exports = { app, server };
