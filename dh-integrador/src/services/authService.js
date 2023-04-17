import axios from 'axios';

const api = axios.create({
  baseURL: 'http://3.92.126.107:5000',
});

// Interceptador de requisições para incluir o token JWT no cabeçalho
api.interceptors.request.use((config) => {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers.Accept = 'application/json';
    config.headers['Content-Type'] = 'application/json';
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
}, (error) => {
  return Promise.reject(error);
});

export default api;