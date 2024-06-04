CREATE OR REPLACE FUNCTION check_holiday_overlap() RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (
        SELECT 1
        FROM employee_holidays
        WHERE employee_id = NEW.employee_id
          AND status = 'Approved'
          AND (NEW.start_date BETWEEN start_date AND end_date
               OR NEW.end_date BETWEEN start_date AND end_date
               OR start_date BETWEEN NEW.start_date AND NEW.end_date
               OR end_date BETWEEN NEW.start_date AND NEW.end_date)
    ) THEN
        RAISE EXCEPTION 'Holiday overlap detected for employee ID %', NEW.employee_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER before_insert_employee_holidays
BEFORE INSERT ON employee_holidays
FOR EACH ROW
EXECUTE FUNCTION check_holiday_overlap();

INSERT INTO employee_holidays (employee_id, start_date, end_date, status)
VALUES (2, '2024-06-03', '2024-09-25', 'Pending');