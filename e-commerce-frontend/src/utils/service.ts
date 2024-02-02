import axios from 'axios';

export const signIn = async (email, password) => {
  try {
    const response = await axios.post(`/api/v1/signin`, { email, password });
    return response.data;
  } catch (error) {
    throw error;
  }
};
