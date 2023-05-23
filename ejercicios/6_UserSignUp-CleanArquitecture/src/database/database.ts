import mongoose from 'mongoose';

export function stablishDatabaseConection() {
  mongoose.set('strictQuery', false);
  
  mongoose.connect('mongodb+srv://admin:admin@cluster0.kousrlu.mongodb.net/app?retryWrites=true&w=majority', {sslValidate: false}).then(() => {
    console.log('Connection to MongoDB server established');
  }).catch((error) => {
    console.log('Unnable to connect to MongoDB server');
    console.log(error)
  });
}