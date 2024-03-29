import axios from 'axios';

export const signIn = async (email: any, password: any) => {
  try {
    const response = await axios.post(`/api/v1/signin`, { email, password });
    return response.data;
  } catch (error) {
    throw error;
  }
};

export const signUp = async (firstName: string, lastName: string, username: string, email: string, password: string) => {
  try {
    const response = await axios.post(`/signup`, {
      firstName,
      lastName,
      username,
      email,
      password,
    });
    return response.data;
  } catch (error) {
    throw error;
  }
};

