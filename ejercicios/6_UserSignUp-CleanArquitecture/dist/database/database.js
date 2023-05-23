"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.stablishDatabaseConection = void 0;
const mongoose_1 = require("mongoose");
function stablishDatabaseConection() {
    mongoose_1.default.set('strictQuery', false);
    mongoose_1.default.connect('mongodb+srv://admin:admin@cluster0.kousrlu.mongodb.net/app?retryWrites=true&w=majority', { sslValidate: false }).then(() => {
        console.log('Connection to MongoDB server established');
    }).catch((error) => {
        console.log('Unnable to connect to MongoDB server');
        console.log(error);
    });
}
exports.stablishDatabaseConection = stablishDatabaseConection;
