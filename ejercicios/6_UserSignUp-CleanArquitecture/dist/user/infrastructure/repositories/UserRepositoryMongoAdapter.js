"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UserRepositoryMongoAdapter = void 0;
const UserModel_1 = require("../models/UserModel");
class UserRepositoryMongoAdapter {
    async save(user) {
        const userDocument = new UserModel_1.UserModel(user);
        await userDocument.save();
    }
    async userExists(email) {
        const user = await UserModel_1.UserModel.exists({ email: email });
        if (user) {
            return true;
        }
        return false;
    }
}
exports.UserRepositoryMongoAdapter = UserRepositoryMongoAdapter;
