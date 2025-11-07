import sys
import os
sys.path.insert(0, os.path.abspath(os.path.dirname(os.path.dirname(__file__))))
from app import greet
import unittest

class TestApp(unittest.TestCase):
    def test_greet(self):
        self.assertEqual(greet("World"), "Hello, World fromFirstName LastName!")

if __name__ == "__main__":
    unittest.main()
