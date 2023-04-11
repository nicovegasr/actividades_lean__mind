import {Email} from "./Email";
/** Approach: Inside-out
 * 1.- Empty email should throw an error
 * 2.- Non-format email should throw an error
 * 3.- Correct email should return the email.
*/
describe('Email test.', () => {

  test('Empty email should throw an error', () => {
    expect( () => Email.createEmail("") ).toThrow("Email is empty.")
  });

})