"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UserModel = void 0;
const mongoose_1 = require("mongoose");
const userSchema = new mongoose_1.Schema({
    name: {
        String,
        required: true,
        trim: true
    },
    email: {
        String,
        required: true,
        unique: true,
        trim: true
    },
    password: {
        String,
        required: true,
        trim: true
    },
    age: {
        Number,
        required: true,
    }
});
exports.UserModel = (0, mongoose_1.model)("User", userSchema);
