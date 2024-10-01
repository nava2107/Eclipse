import { effect, signal } from '@vaadin/hilla-react-signals';
import { AppLayout } from '@vaadin/react-components';
import { Suspense, useEffect } from 'react';
import { Outlet } from 'react-router-dom';

const defaultTitle = document.title;
const documentTitleSignal = signal('');
effect(() => {
    document.title = documentTitleSignal.value;
});

// Publish for Vaadin to use
(window as any).Vaadin.documentTitleSignal = documentTitleSignal;

export default function MainLayout() {
    // No longer using the SideNav or navigation logic
    useEffect(() => {
        documentTitleSignal.value = defaultTitle; // Set default title
    }, []);

    return (
        <AppLayout>
            <Suspense>
                <Outlet />
            </Suspense>
        </AppLayout>
    );
}
