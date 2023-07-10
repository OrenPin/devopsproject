import requests
import unittest

class TestServer(unittest.TestCase):
    def test_logs_endpoint(self):
        response = requests.get('http://localhost:8080/api/logs')
        self.assertEqual(response.status_code, 200, 'The logs endpoint should return a 200 status code')
        self.assertEqual(response.headers.get('Content-Type'), 'application/json', 'The logs endpoint should return JSON data')
        # Add specific assertions for the content of the response

    def test_transaction_endpoint(self):
        initial_response = requests.get('http://localhost:8080/api/logs')
        initial_logs_count = len(initial_response.json())

        response = requests.get('http://localhost:8080/api/transaction')
        self.assertEqual(response.status_code, 200, 'The transaction endpoint should return a 200 status code')
        self.assertEqual(response.text, 'A new transaction has been created.', 'The transaction endpoint should return a success message')

        final_response = requests.get('http://localhost:8080/logs')
        final_logs_count = len(final_response.json())
        self.assertEqual(final_logs_count, initial_logs_count + 1, 'The transaction endpoint should create a new log entry')

    def test_wrong_endpoint(self):
        response = requests.get('http://localhost:8080/non_existent_endpoint')
        self.assertEqual(response.status_code, 404, 'The non-existent endpoint should return a 404 status code')

if __name__ == "__main__":
    unittest.main()
