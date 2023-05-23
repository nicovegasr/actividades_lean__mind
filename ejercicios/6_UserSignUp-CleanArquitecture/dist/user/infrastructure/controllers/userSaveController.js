"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.userSaveController = exports.userRoute = void 0;
const UseCaseSaveUser_1 = require("../../aplication/usecases/UseCaseSaveUser");
const UserDTO_1 = require("../dto/UserDTO");
const UserRepositoryMongoAdapter_1 = require("../repositories/UserRepositoryMongoAdapter");
const UserRequestValidate_1 = require("../validate/UserRequestValidate");
const express = require("express");
exports.userRoute = express.Router();
const userSaveController = async (req, res) => {
    try {
        const userValidated = UserRequestValidate_1.UserRequestValidate.create(req.body.name, req.body.email, req.body.password, req.body.age);
        const userRepository = new UserRepositoryMongoAdapter_1.UserRepositoryMongoAdapter();
        const user = UserDTO_1.UserDTO.createDomainUser(userValidated);
        await (0, UseCaseSaveUser_1.UseCaseSaveUser)(user, userRepository);
        res.status(200).json({ user: user });
    }
    catch (error) {
        res.status(400).json({ message: error.message });
    }
};
exports.userSaveController = userSaveController;
exports.userRoute.post("/save_user", exports.userSaveController);
