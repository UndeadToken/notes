#!/usr/bin/env python3
"""
AWS Certified Developer Associate Exam Quiz
Randomly selects 10 questions from all question files and provides interactive quiz.
"""

import os
import re
import random
from pathlib import Path
from typing import List, Dict, Tuple


class Question:
    """Represents a single exam question."""
    
    def __init__(self, text: str, options: List[str], answer: str, explanation: str, source: str):
        self.text = text
        self.options = options
        self.answer = answer
        self.explanation = explanation
        self.source = source


def parse_question_file(filepath: Path) -> List[Question]:
    """Parse a markdown question file and extract all questions."""
    questions = []
    
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # Split by question headers (### followed by number)
    question_blocks = re.split(r'\n### \d+\.', content)
    
    for block in question_blocks[1:]:  # Skip first empty split
        lines = block.strip().split('\n')
        if len(lines) < 3:
            continue
        
        # Extract question text (first line)
        question_text = lines[0].strip()
        
        # Extract options (lines starting with A., B., C., D.)
        options = []
        answer = None
        explanation = None
        
        i = 1
        while i < len(lines):
            line = lines[i].strip()
            
            # Option line
            if re.match(r'^[A-D]\.', line):
                options.append(line)
            
            # Answer line
            elif line.startswith('**Answer:**'):
                answer = line.replace('**Answer:**', '').strip()
            
            # Explanation line
            elif line.startswith('**Explanation:**'):
                explanation = line.replace('**Explanation:**', '').strip()
            
            i += 1
        
        if question_text and len(options) == 4 and answer and explanation:
            questions.append(Question(
                text=question_text,
                options=options,
                answer=answer,
                explanation=explanation,
                source=filepath.stem
            ))
    
    return questions


def load_all_questions(questions_dir: Path) -> List[Question]:
    """Load all questions from all markdown files in questions directory."""
    all_questions = []
    
    for filepath in questions_dir.glob('*.md'):
        questions = parse_question_file(filepath)
        all_questions.extend(questions)
        print(f"Loaded {len(questions)} questions from {filepath.name}")
    
    return all_questions


def display_question(question: Question, question_num: int, total: int):
    """Display a single question with options."""
    print(f"\n{'='*80}")
    print(f"Question {question_num}/{total} (Topic: {question.source})")
    print(f"{'='*80}")
    print(f"\n{question.text}\n")
    
    for option in question.options:
        print(f"  {option}")
    print()


def get_user_answer() -> str:
    """Get user's answer with validation."""
    while True:
        answer = input("Your answer (A/B/C/D): ").strip().upper()
        if answer in ['A', 'B', 'C', 'D']:
            return answer
        print("Invalid input. Please enter A, B, C, or D.")


def run_quiz(questions: List[Question], num_questions: int = 10):
    """Run the interactive quiz."""
    print("\n" + "="*80)
    print("AWS Certified Developer Associate - Practice Quiz")
    print("="*80)
    print(f"\nYou will be asked {num_questions} random questions.")
    print("Answer each question by typing A, B, C, or D.\n")
    input("Press Enter to start...")
    
    # Randomly select questions
    selected_questions = random.sample(questions, min(num_questions, len(questions)))
    
    correct_count = 0
    results = []
    
    for i, question in enumerate(selected_questions, 1):
        display_question(question, i, num_questions)
        user_answer = get_user_answer()
        
        is_correct = user_answer == question.answer
        if is_correct:
            correct_count += 1
            print("\n✅ Correct!")
        else:
            print(f"\n❌ Incorrect. The correct answer is: {question.answer}")
        
        print(f"Explanation: {question.explanation}")
        
        results.append({
            'question': question.text,
            'your_answer': user_answer,
            'correct_answer': question.answer,
            'is_correct': is_correct,
            'topic': question.source
        })
        
        if i < num_questions:
            input("\nPress Enter for next question...")
    
    # Display final results
    print("\n" + "="*80)
    print("QUIZ RESULTS")
    print("="*80)
    print(f"\nScore: {correct_count}/{num_questions} ({(correct_count/num_questions)*100:.1f}%)")
    
    if correct_count == num_questions:
        print("🎉 Perfect score! Excellent work!")
    elif correct_count >= num_questions * 0.8:
        print("👍 Great job! You're well prepared!")
    elif correct_count >= num_questions * 0.6:
        print("📚 Good effort! Keep studying!")
    else:
        print("💪 Keep practicing! Review the topics you missed.")
    
    # Show summary of incorrect answers
    incorrect = [r for r in results if not r['is_correct']]
    if incorrect:
        print(f"\n\nIncorrect Answers ({len(incorrect)}):")
        print("-" * 80)
        for i, result in enumerate(incorrect, 1):
            print(f"\n{i}. Topic: {result['topic']}")
            print(f"   Question: {result['question'][:100]}...")
            print(f"   Your answer: {result['your_answer']}")
            print(f"   Correct answer: {result['correct_answer']}")
    
    print("\n" + "="*80)


def main():
    """Main entry point."""
    # Get the questions directory
    script_dir = Path(__file__).parent
    questions_dir = script_dir / 'questions'
    
    if not questions_dir.exists():
        print(f"Error: Questions directory not found at {questions_dir}")
        return
    
    print("Loading questions...")
    all_questions = load_all_questions(questions_dir)
    
    if not all_questions:
        print("Error: No questions found!")
        return
    
    print(f"\nTotal questions available: {len(all_questions)}")
    
    # Ask user how many questions
    while True:
        try:
            num_str = input("\nHow many questions would you like? (default: 10): ").strip()
            if not num_str:
                num_questions = 10
            else:
                num_questions = int(num_str)
            
            if 1 <= num_questions <= len(all_questions):
                break
            else:
                print(f"Please enter a number between 1 and {len(all_questions)}")
        except ValueError:
            print("Invalid input. Please enter a number.")
    
    run_quiz(all_questions, num_questions)


if __name__ == '__main__':
    main()
